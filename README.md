# jfix-project-template
Template for new gradle project 

#### Build
##### Deploy to remote maven repository:  
```
gradle publishAllPublicationsToMavenRepository
```
Required properties:
```
repositoryUser= 
repositoryPassword=
repositoryUrl=
```

##### Deploy to local maven repository:  
```
gradle publishToMavenLocal
```

##### Deploy to Maven Central repository:
```
gradle publishToSonatype
```
Required properties:
```
repositoryUser=
repositoryPassword=
signingKeyId=
signingPassword=
```

# New Project template
Common project configuration requires properties provided through `gradle.properties` or environment:
```properties
repositoryUrl= <https://path/to/remote/repository> or <file:///path/to/local/repository>
repositoryUser= login for remote repository
repositoryPassword= password for remote repository
signingKeyId= gpg short keyid, could be obtained via gpg --list-keys --keyid-format short
signingPassword= key store file password
signingSecretKeyRingFile= /path/to/.gnupg/secring.gpg key store file
  
Use `gpg --export-secret-keys -o secring.gpg` to export secret key to old format supported by gradle
```  
## Travis and Maven Central

To deploy project to maven central you have 
 - create account on sonatype
 - generate private key and sign artifacts before publication 
 
 Get list of keys in your local secring.gpg store
 ```
 gpg --list-keys
 ```
 
Generate private key or use existing one.  
If you already have private key `<my-sec-key>.gpg` you should import it to local storage:  
```
gpg --allow-secret-key-import --import <my-sec-key>.gpg
```  
During import use password that you will use in `signing.password` property in travis.ci file and in gradle. 

Export private key to old format: `secring.gpg`   
`gpg --export-secret-keys -o secring.gpg`

File `secring.gpg` will be used in next steps. We will encrypt this file by travis encryption key and commit to repository.

Install travis ci
```
sudo apt install ruby ruby-dev
sudo gem install travis
PATH=$PATH:/usr/local/bin
```
Login to travis site with github account.
Then login to travis from console.
```
travis login
```
 
Encrypt `secring.gpg` and add it to your project repository `secring.gpg.enc`
```
travis encrypt-file secring.gpg 
``` 
Add decoding script into setup section of `.travis.yml`
```
jobs:
  include:
    - stage: build
      ...
      before_script: if [[ $encrypted_0cj38rd_key ]]; then openssl aes-256-cbc -K $encrypted_0cj38rd_key...

```

Encrypt project properties and add to secure section of `.travis.yml`
```
travis encrypt repositoryUrl=https://path/to/remote/repository
travis encrypt signingPassword=30cDKf34rdsl
...
```
```
env:
  global:
  - signingSecretKeyRingFile="`pwd`/secring.gpg"
  - secure: "MpiifWpBpsDfZ4OnQna/yRD4JaKXr9VvPXT4Ik0Njc/6y3BBGOsytXj4

```

## Generate .travis.yml
Script 
- encrypt gradle properties
- encrypt secring.gpg key store
- generate `.travis.yml` tempalte

`jfix-github-project-template/jfix-github-project-tempalte.py`



# Gradle Release Plugin project details    
## How to build this project
To build and deploy gradle release plugin project to local maven repository run:
```
gradle build publishToMavenLocal
```

## Deploy this project to remote repository
Provide credentials for repository.  
Provide signature.  
```
~/.gradle/gradle.properties

repositoryUser = user
repositoryPassword = password
repositoryUrl = url-to-repository
signingKeyId = key id 8 letters long (gpg --list-keys --keyid-format short)
signingPassword = passowrd to acces secring
signingSecretKeyRingFile = /home/user/.gnupg/secring.gpg
```
Specify version in
gradle.properties
```
version=x.y.z
```
commit new tag with name x.y.z  
then run
```
gradle build publish
```
