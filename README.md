# AndroidDaggerUsage

This application shows the usage of Dagger 2 in Android.

Consider the next points:

 - Include the following classpath at /build.gradle:

```
    dependencies {
        classpath 'com.neenbedankt.gradle.plugins:android-apt:1.8'
    }
```
 - Add the apt plugin after the android application plugin at /app/build.gradle:

```
    apply plugin: 'com.android.application'
    apply plugin: 'com.neenbedankt.android-apt'
```

 - Include the following dependencies at /app/build.gradle:

```
dependencies {
    compile 'com.google.dagger:dagger:2.0'
    provided 'com.google.dagger:dagger-compiler:2.0'
    provided 'org.glassfish:javax.annotation:10.0-b28'
}
```

### Version
1.0


