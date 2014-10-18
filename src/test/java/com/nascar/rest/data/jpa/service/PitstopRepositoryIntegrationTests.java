/*
 * Copyright 2012-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.nascar.rest.data.jpa.service;

import com.nascar.rest.NascarPitStopApiService;
import com.nascar.rest.data.jpa.domain.Pitstop;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Integration tests for {@link PitstopRepository}.
 *
 * @author sefverl.balasingam@outlook.com
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = NascarPitStopApiService.class)
public class PitstopRepositoryIntegrationTests {

    @Autowired
    PitstopRepository repository;

    @Test
    public void findsFirstPageOfPitstops() {

        Page<Pitstop> pitstops = this.repository.findAll(new PageRequest(0, 10));
        assertThat(pitstops.getTotalElements(), is(greaterThan(5L)));
    }
}
