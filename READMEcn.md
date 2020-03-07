# ImageFormat
[![Platform](https://img.shields.io/badge/platform-android-green.svg)](http://developer.android.com/index.html)
[![API](https://img.shields.io/badge/API-7%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=7)
[![License](https://img.shields.io/badge/License-MIT-blue.svg?style=flat)](http://opensource.org/licenses/MIT)
[![](https://jitpack.io/v/hzw1199/ImageFormat.svg)](https://jitpack.io/#hzw1199/ImageFormat)

![](/media/homepage.png)

## Features

* 支持从```InputStream```或者```File```解析四种格式：```jpg``` 、 ```png``` 、 ```webp``` 、 ```gif```
* 从文件本身解析格式，而不是从扩展名获取
* ```FormatHelper.getFormat(InputStream inputStream)```
* ```FormatHelper.getFormat(File file)```

## Usage

### Step 1

在project的build.gradle中加入以下语句:  

```
allprojects {
    repositories {
        ...
        maven { url "https://jitpack.io" }
    }
}
```

在module的build.gradle中加入以下语句:  

```
dependencies {
    compile 'com.github.hzw1199:ImageFormat:1.0.0'
}
```

### Step 2

解析格式

```java
String FormatHelper.getFormat(InputStream inputStream)
```

或者

```java
String FormatHelper.getFormat(File file)
```

返回值为```jpg``` 、 ```png``` 、 ```webp``` 、 ```gif```中的一个

## Proguard
无需配置混淆规则

## Tip

* 使用前请查看demo
* 若对你有帮助请加星

## About Me

* [Home Page](https://zongheng.pro)
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