package com.projeto_inicial.projeto_inicial.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.projeto_inicial.projeto_inicial.Model.Farm;
import com.projeto_inicial.projeto_inicial.Service.FarmServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = FarmController.class)
public class FarmControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private FarmController farmController;

    @MockBean
    private FarmServiceImpl farmService;

    private final String url = "http://localhost:8080/api/v1/farms";

    private List<Farm> farmList;

    private ObjectMapper mapper = new ObjectMapper();

    public FarmControllerTests() {
    }

    @BeforeEach
    public void setup(){
        farmList = new ArrayList<Farm>();
        farmList.add(new Farm("123", "Farm 1"));
        farmList.add(new Farm("456", "Farm 2"));
        farmList.add(new Farm("789", "Farm 3"));
    }

    @Test
    public void testGetAllSuccess() throws Exception{
        Mockito.when(this.farmService.getAll()).thenReturn(farmList);
        String listJson = mapper.writeValueAsString(farmList);

        this.mockMvc.perform(get(url))
                .andExpect(status().isOk()).
                andExpect(content().string(listJson));
    }

    @Test
    public void testFetchByIdSuccess() throws Exception{
        Mockito.when(this.farmService.fetchById("123")).thenReturn(farmList.get(0));
        String farmId = "/123";
        String farmJson = mapper.writeValueAsString(farmList.get(0));

        this.mockMvc.perform(get(url + farmId))
                .andExpect(status().isOk()).
                andExpect(content().string(farmJson));
    }

    @Test
    public void testCreateSuccess() throws Exception{
        Mockito.when(this.farmService.create(farmList.get(0))).thenReturn(farmList.get(0));
        String farmJson = mapper.writeValueAsString(farmList.get(0));

        this.mockMvc.perform(post(url)
                .content(farmJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().string(farmJson));
    }

    @Test
    public void testRemoveByIdSuccess() throws Exception{
        Mockito.doNothing().when(this.farmService).remove("123");
        String farmId = "/123";

        this.mockMvc.perform(delete(url + farmId))
                .andExpect(status().isOk());
    }

    @Test
    public void testFetchAllByNameSuccess() throws Exception{
        for (Farm f: farmList
             ) {
            f.setName("Farm");
        }
        Mockito.when(this.farmService.fetchAllByFarmName("Farm")).thenReturn(farmList);
        String farmName = "/Farm";
        String listJson = mapper.writeValueAsString(farmList);

        this.mockMvc.perform(get(url + "/by_name" + farmName))
                .andExpect(status().isOk())
                .andExpect(content().string(listJson));
    }

    @Test
    public void testGetProductivitySuccess() throws Exception{
        Mockito.when(this.farmService.getProductivity("123")).thenReturn(BigDecimal.valueOf(30.5));
        String farmId = "/123";

        this.mockMvc.perform(get(url + farmId + "/get_productivity"))
                .andExpect(status().isOk())
                .andExpect(content().string(BigDecimal.valueOf(30.5).toString()));
    }
}
