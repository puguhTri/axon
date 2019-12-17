package com.pug.axon.axon;

import com.pug.axon.axon.dto.JenisFasilitasDto;
import com.pug.axon.axon.services.commands.JenisFasilitasService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AxonApplicationTests {

  @Autowired
  JenisFasilitasService jenisFasilitasService;


	@Test
	public void contextLoads() {

	  for(int i = 1; i < 1001; i++){
      JenisFasilitasDto jenisFasilitasDto = new JenisFasilitasDto();
      jenisFasilitasDto.setKode("JF-"+i);
      jenisFasilitasDto.setNama("Nama-"+i);
      jenisFasilitasDto.setStatus("Aktif");
      jenisFasilitasService.createJenisFasilitas(jenisFasilitasDto);
    }
	}

}
