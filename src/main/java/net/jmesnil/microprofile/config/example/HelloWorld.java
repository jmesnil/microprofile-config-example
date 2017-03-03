/*
 * JBoss, Home of Professional Open Source
 * Copyright 2015, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.jmesnil.microprofile.config.example;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.spi.ConfigSource;

/**
 * A simple REST service which is able to say hello to someone using HelloService Please take a look at the web.xml where JAX-RS
 * is enabled
 *
 * @author gbrey@redhat.com
 *
 */

@Path("/")
public class HelloWorld {

    @Inject
    Config config;

    @GET
    @Path("/all")
    public String getAllProperties() {
        System.out.println("config = " + config);
        StringBuilder out = new StringBuilder();

        out.append("<h2>ConfigSources</h2>");
        out.append("<ul>");
        for (ConfigSource source : config.getConfigSources()) {
            out.append("<li>" + source.getId() + " - " + source.getOrdinal() + "</li>");
        }
        out.append("</ul>");

        out.append("<h2>Properties</h2>");
        out.append("<ul>");
        for (String name : config.getPropertyNames()) {
            out.append(String.format("<li>%s = %s</li>\n", name, config.getString(name).get()));
        }
        out.append("</ul>");
        return out.toString();
    }
}
