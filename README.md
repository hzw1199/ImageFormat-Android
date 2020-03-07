# ImageFormat
[![Platform](https://img.shields.io/badge/platform-android-green.svg)](http://developer.android.com/index.html)
[![API](https://img.shields.io/badge/API-7%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=7)
[![License](https://img.shields.io/badge/License-MIT-blue.svg?style=flat)](http://opensource.org/licenses/MIT)
[![](https://jitpack.io/v/hzw1199/ImageFormat.svg)](https://jitpack.io/#hzw1199/ImageFormat)

[中文看这里](/READMEcn.md)  

![](/media/homepage.png)

# Features

* Support decode formats: ```jpg``` / ```png``` / ```webp``` / ```gif``` from ```InputStream``` or ```File```
* Decode from files themselves, not from the extension
* ```FormatHelper.getFormat(InputStream inputStream)```
* ```FormatHelper.getFormat(File file)```

# Usage

### Step 1

Add it in your build.gradle at the end of repositories:  

```
allprojects {
    repositories {
        ...
        maven { url "https://jitpack.io" }
    }
}
```

Add the dependency in the form:  

```
dependencies {
    compile 'com.github.hzw1199:ImageFormat:1.0.0'
}
```

### Step 2

Decode format

```java
String FormatHelper.getFormat(InputStream inputStream)
```

or

```java
String FormatHelper.getFormat(File file)
```

returns one of ```jpg``` / ```png``` / ```webp``` / ```gif```

## Proguard
No need to add more proguard rules.

## Tip

* Please check the demo before use.
* If this project helps you, please star me.

## About Me

* [Home Page](https://zongheng.pro/index.html)
* [Blog](https://blog.zongheng.pro)

## License

```
The MIT License (MIT)

Copyright (c) 2020 ImageFormat

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
```
