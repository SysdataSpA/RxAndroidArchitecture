# RxAndroidArchitecture
A powerful android rx-active Architecture

## 1. A Brief Introduciton
The app is a sample project that shows how to implement the RxAndroidArchitecture into your Android app.

### 1.1 What is RxAndroidArchitecture?
It is a layer-based architecture that allows a real disentangle of the UI components from the business logic. 

The main components are:

* UI
* Coordinator Manager and Coordinators
* UseCase
* Repositories
* EventDispatcher

### 1.2 RxAndroidArchitecture main components

#### 1.2.1 UI

The UI layer of the architecture comprises activities, fragments and views. 

The role of an activity is to coordinate the navigations by managing widgets and screens. 

Fragments are instead the components that request and use the coordinators requesting them to the Coordinator Manager. Each fragment can use multiple coordinators and one coodinators can be used by several fragments.

The communications among them take place by means of an EventDispatcher.

#### 1.2.2 Coordinator Manager and Coordinators

#### 1.2.3 EventDispatcher

#### 1.2.4

#### 1.2.5




### 1.3 Major Classes

## 2. RxAndroidArchitecture Classes Overview

### 2.1
### 2.2
### 2.3
### 2.4
### 2.5

## 3. How to use it?

### 3.1 Installation
    dependencies {
        compile 'com.baseandroid:baseandroid-navigation:0.0.6'
        compile 'com.baseandroid:baseandroid-core:0.0.6'
        compile 'com.baseandroid:baseandroid-busadapter:0.0.6'
        compile 'com.baseandroid:baseandroid-coordinatoradapter:0.0.6'
        compile 'com.baseandroid:baseandroid-repositoryadapter:0.0.6'
        compile 'com.baseandroid:baseandroid-rxeventdispatcher:0.0.6'
        compile 'com.baseandroid:baseandroid-rxcoordinator:0.0.6'
        compile 'com.baseandroid:baseandroid-rxrepository:0.0.6'
    }


# Licence

      Copyright (C) 2017 Sysdata S.p.A.

      Licensed under the Apache License, Version 2.0 (the "License");
      you may not use this file except in compliance with the License.
      You may obtain a copy of the License at

          http://www.apache.org/licenses/LICENSE-2.0

      Unless required by applicable law or agreed to in writing, software
      distributed under the License is distributed on an "AS IS" BASIS,
      WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
      See the License for the specific language governing permissions and
      limitations under the License.
 
