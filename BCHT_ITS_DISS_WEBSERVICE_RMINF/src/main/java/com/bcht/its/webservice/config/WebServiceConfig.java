/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.bcht.its.webservice.config;

import com.bcht.its.webservice.impl.BchtRminfoImpl;
import com.bcht.its.webservice.impl.TmnlManagerImpl;
import com.bcht.its.webservice.impl.UserManagerImpl;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

@Configuration
public class WebServiceConfig {

    @Autowired
    private Bus bus;

    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, new UserManagerImpl());
        endpoint.publish("/UserManager");
        return endpoint;
    }

    @Bean
    public Endpoint tmnlManagerEndpoint(){
        EndpointImpl endpoint = new EndpointImpl(bus, new TmnlManagerImpl());
        endpoint.publish("/TmnlManager");
        return endpoint;
    }


    @Bean
    public Endpoint bchtRminfEndpoint(){
        EndpointImpl endpoint = new EndpointImpl(bus, new BchtRminfoImpl());
        endpoint.publish("/bchtRminf");
        return endpoint;
    }

}
