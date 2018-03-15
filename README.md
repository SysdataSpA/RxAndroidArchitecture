# RxAndroidArchitecture
A powerful android rx-active Architecture

## 1. A Brief Introduciton
The app is a sample project that shows how to implement the RxAndroidArchitecture into your Android app.

### 1.1 What is RxAndroidArchitecture?
It is a layer-based architecture that allows a real disentangle of the UI components from the business logic. 

The main components are:

* UI
* Coordinator Manager and Coordinators
* EventDispatcher
* UseCase
* Repository

### 1.2 RxAndroidArchitecture main components

#### 1.2.1 UI

The UI layer of the architecture comprises activities, fragments and views. 
The role of an activity is to coordinate the navigations by managing widgets and screens. 

Fragments are instead the components that request and use the coordinators requesting them to the Coordinator Manager. Each fragment can use multiple coordinators and one coodinators can be used by several fragments.
The communications among them take place by means of an EventDispatcher.

#### 1.2.2 Coordinator Manager and Coordinators

A **Coordinator** can be thought as an advanced version of the **Presenter** of the MVP model. Compared to it, the coordinator offers the following advantages:

* reference decoupling from the views
* allows for multi-layers inner structure 
* TDD oriented

The **Coordinator** - **UI** communication is based on an **Events** exchange mechanism and the events are carried by an **EventBus** (here implemented by the **EventDispatcher** object).  
A single coordinator can coordinate multiple business logic activities that are executed by objects of type **UseCase**.

The **Coordinator** object is heavly based on Reactive Programming and it associates a **Subscriber** to the UseCases. A Subscriber is an object that is able to handle results from UseCases. 
Moreover the a **Coordinator** handles answers from subscribers and is able to propagate them to the views by means of the mechanism explaind before. 

The **CoordinatorManager** handles the initializations of the coordinators. It stores them into a map. In such a paradigm the coordinators are treated as singletons.

#### 1.2.3 EventDispatcher

The **EventDispatcher** is an EventBus made of two RxBuses: one for the UI thread and another one for asyncronous operations (network calls, CRUD oprations, etc).

The **Event** annotation identifies the classes that defines the type of object that will be sent through the EventDispatcher.post(Object o) method.

#### 1.2.4 UseCase
A **UseCase** is a wrapper for a small business logic operation. A **UseCase** can use one or more **Repository** to get or write the requested data, then it returns the response event.

#### 1.2.5 Repository
A **Repository** handles the process of saving or retrieving data from a datasource, it is managed by one or more **UseCase**.

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
 
