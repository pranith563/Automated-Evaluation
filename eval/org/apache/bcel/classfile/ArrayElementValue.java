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
package org.apache.bcel.classfile;

import java.io.DataOutputStream;
import java.io.IOException;

/**
 * @since 6.0
 */
public class ArrayElementValue extends ElementValue
{
    // For array types, this is the array
    private final ElementValue[] evalues;

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < evalues.length; i++)
        {
            sb.append(evalues[i]);
            if ((i + 1) < evalues.length) {
                sb.append(",");
            }
        }
        sb.append("}");
        return sb.toString();
    }

    public ArrayElementValue(final int type, final ElementValue[] datums, final ConstantPool cpool)
    {
        super(type, cpool);
        if (type != ARRAY) {
            throw new RuntimeException(
                    "Only element values of type array can be built with this ctor - type specified: " + type);
        }
        this.evalues = datums;
    }

    @Override
    public void dump(final DataOutputStream dos) throws IOException
    {
        dos.writeByte(super.getType()); // u1 type of value (ARRAY == '[')
        dos.writeShort(evalues.length);
        for (final ElementValue evalue : evalues) {
            evalue.dump(dos);
        }
    }

    @Override
    public String stringifyValue()
    {
        final StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < evalues.length; i++)
        {
            sb.append(evalues[i].stringifyValue());
            if ((i + 1) < evalues.length) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public ElementValue[] getElementValuesArray()
    {
        return evalues;
    }

    public int getElementValuesArraySize()
    {
        return evalues.length;
    }
}
