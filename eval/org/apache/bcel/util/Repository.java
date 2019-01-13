/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */
package org.apache.bcel.util;

import org.apache.bcel.classfile.JavaClass;

/**
 * Abstract definition of a class repository. Instances may be used
 * to load classes from different sources and may be used in the
 * Repository.setRepository method.
 *
 * @see org.apache.bcel.Repository
 * @version $Id: Repository.java 1806200 2017-08-25 16:33:06Z ggregory $
 */
public interface Repository {

    /**
     * Store the provided class under "clazz.getClassName()"
     */
    void storeClass( JavaClass clazz );


    /**
     * Remove class from repository
     */
    void removeClass( JavaClass clazz );


    /**
     * Find the class with the name provided, if the class
     * isn't there, return NULL.
     */
    JavaClass findClass( String className );


    /**
     * Find the class with the name provided, if the class
     * isn't there, make an attempt to load it.
     */
    JavaClass loadClass( String className ) throws java.lang.ClassNotFoundException;


    /**
     * Find the JavaClass instance for the given run-time class object
     */
    JavaClass loadClass( Class<?> clazz ) throws java.lang.ClassNotFoundException;


    /** Clear all entries from cache.
     */
    void clear();


    /** Get the ClassPath associated with this Repository
     */
    ClassPath getClassPath();
}
