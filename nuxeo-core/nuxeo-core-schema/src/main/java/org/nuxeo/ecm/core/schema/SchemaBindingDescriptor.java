/*
 * (C) Copyright 2006-2011 Nuxeo SA (http://nuxeo.com/) and others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Contributors:
 *     Nuxeo - initial API and implementation
 *
 * $Id$
 */

package org.nuxeo.ecm.core.schema;

import java.io.File;
import java.io.InputStream;

import org.nuxeo.common.xmap.annotation.XNode;
import org.nuxeo.common.xmap.annotation.XObject;
import org.nuxeo.runtime.model.RuntimeContext;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 */
@XObject("schema")
public class SchemaBindingDescriptor {

    @XNode("@name")
    public String name;

    @XNode("@src")
    public String src;

    public File file;

    @XNode("@prefix")
    public String prefix = "";

    @XNode("@override")
    public boolean override = false;

    @XNode("@isVersionWritable")
    public boolean isVersionWritable = false;

    @XNode("@xsdRootElement")
    public String xsdRootElement;

    /**
     * 适用于内部api加载指定的字符输入流
     */
    private InputStream inputStream = null;

    // this is set by the type service to the context that knows how to locate
    // the schema file
    public RuntimeContext context;

    public SchemaBindingDescriptor() {
    }

    public SchemaBindingDescriptor(String name, String prefix) {
        this.name = name;
        this.prefix = prefix;
    }

    public SchemaBindingDescriptor(String name, String src, String prefix, boolean override, RuntimeContext context) {
        this.name = name;
        this.src = src;
        this.prefix = prefix;
        this.override = override;
        this.context = context;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override
    public String toString() {
        return "Schema: " + name;
    }

}
