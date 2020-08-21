package com.memorize.api.controller;

import com.memorize.api.service.INumberService;
import com.memorize.model.number.NumberDto;
import com.memorize.security.security.repository.UserRepositoryImpl;
import com.memorize.security.security.util.JwtUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.UUID;

import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(NumberDataController.class)
public class NumberDataTest {
    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private INumberService iNumberService;

    @MockBean
    private JwtUtil jwtUtil;

    @MockBean
    private UserRepositoryImpl userRepository;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .apply(springSecurity())
                .build();
    }

    @WithMockUser(value = "spring")
    @Test
    public void shouldFetchNumberData() throws Exception {
        var athleteId = UUID.randomUUID();
        var url = String.format("/api/v1/athletes/%s/numbers", athleteId);

        when(iNumberService.getNumberData(UUID.randomUUID()))
                .thenReturn(dummyNumberDto(athleteId));

        mockMvc.perform(get(url).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    private NumberDto dummyNumberDto(UUID athleteId) {
        var dummyNumberDto = new NumberDto();
        dummyNumberDto.setId(athleteId);
        dummyNumberDto.setBestScore(100);

        return dummyNumberDto;
    }

}
