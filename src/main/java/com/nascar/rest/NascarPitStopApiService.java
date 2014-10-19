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
 *
 * @author sefverl.balasingam@outlook.com
 */

package com.nascar.rest;

import com.nascar.rest.configuration.PitstopViewConfiguration;
import com.nascar.rest.data.jpa.domain.Pitstop;
import com.nascar.rest.data.jpa.service.PitstopRepository;
import com.nascar.rest.input.feed.entity.RaceFeed;
import com.nascar.rest.input.feed.entity.RacePitstop;
import com.nascar.rest.input.feed.entity.RaceVehicle;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableJpaRepositories
@EnableWebMvc
@Import({RepositoryRestMvcConfiguration.class, PitstopViewConfiguration.class})
@ComponentScan
@EnableAutoConfiguration
public class NascarPitStopApiService {
    private static RaceFeed lastRaceFeed = null;

    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext context = SpringApplication.run(NascarPitStopApiService.class, args);
        while (context.isActive()) {
            addPitstopDataFromLiveFeed("http://localhost:9000/api/livefeed", context);
            Thread.sleep(10000);
        }

    }

    private static void addPitstopDataFromLiveFeed(String feedUrl, ConfigurableApplicationContext context) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        PitstopRepository pitstopRepository = context.getBean(PitstopRepository.class);

        RaceFeed raceFeed = restTemplate.getForObject(feedUrl, RaceFeed.class);
        if (null != lastRaceFeed && raceFeed.equals(lastRaceFeed)) {
            lastRaceFeed = raceFeed;
        } else {
            for (RaceVehicle raceVehicle : raceFeed.getVehicleList()) {
                for (RacePitstop racePitstop : raceVehicle.getPitstops()) {
                    Pitstop pitstop = Pitstop.getBuilder(raceVehicle.getVehicleNumber(),
                            racePitstop.getInElapsedTime(), racePitstop.getOutElapsedTime()).build();
                    pitstopRepository.save(pitstop);
                }
            }
            lastRaceFeed = raceFeed;
        }

    }
}
