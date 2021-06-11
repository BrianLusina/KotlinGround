# KotlinGround

[![Tests](https://github.com/BrianLusina/KotlinGround/actions/workflows/tests.yml/badge.svg)](https://github.com/BrianLusina/KotlinGround/actions/workflows/tests.yml)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/132a1eb4abe1424790c4832984f6e73b)](https://www.codacy.com/app/BrianLusina/KotlinGround?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=BrianLusina/KotlinGround&amp;utm_campaign=Badge_Grade)

A series of code snippets written in Kotlin. This is used as a learning tool into the [Kotlin](https://kotlinlang.org/)
programming language.

## Getting Started

Simply clone the repository and run any code snippet. All the code snippets, or 90% that count have tests backing them.
The structure of the tests directory directly matches the structure of the app directory, which houses all the code
snippets.

```sh
$ git clone https://github.com/BrianLusina/KotlinGround.git
$ cd KotlinGround
$ ./gradlew test
```

It is preferrable that you run tests and any other task with the Gradle Wrapper, as this will ensure you are using the
correct version of gradle.

## Pre-requisites

Kotlin Compiler and gradle are the main pre-requisites you will need when using this repository. Downloading them is
easy using [sdkman](http://sdkman.io/install.html). Follow the instructions to get a copy of sdkman and then install
kotlin and gradle as follows:

```sh
$ sdk install kotlin
...
$ sdk install gradle
```

Enjoy!
