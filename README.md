# ImageSliderrKotlin

in project level build.gradle add following

```
allprojects {
    repositories {
       --------        
       --------
        maven { url 'https://jitpack.io' } 
    }
  }
```
under depedencies add the follwing gradle pllugin

```
dependencies {
    -----
    implementation 'com.github.venkateshguddanti:ImageSliderrKotlin:1.1.0'
}
```
The basic usage is given in above repository.
