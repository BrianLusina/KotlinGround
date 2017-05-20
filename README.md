# JVM PlayGround

[![Build Status](https://travis-ci.org/BrianLusina/Java-Playground.svg?branch=master)](https://travis-ci.org/BrianLusina/Java-Playground)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/ee8646cf1ed14cf4a2624601d1caa7fd)](https://www.codacy.com/app/BrianLusina/Java-Playground?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=BrianLusina/Java-Playground&amp;utm_campaign=Badge_Grade)
[![CircleCI](https://circleci.com/gh/BrianLusina/Java-Playground.svg?style=svg)](https://circleci.com/gh/BrianLusina/Java-Playground)

JVM PlayGround has a series of small programs and snippets in Java Groovy, Kotlin and Scala.
Reason for naming it so is because of how these languages interact with each other in the JVM.

The project is divided into  modules, each module targets the specific language, however, the whole project has the 3 modules included in `settings.gradle`, therefore all tests are run together to create a unified coverage report.

Each module has its own gradle configuration and can be run independently if one `cd`s into the module directory and runs various gradle tasks

To run the tests on the overall project

``` sh
$ gradle test
```


Enjoy!