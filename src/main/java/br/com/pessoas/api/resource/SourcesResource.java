package br.com.pessoas.api.resource;

import java.util.HashMap;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@Api(tags = "Source")
@RestController
public class SourcesResource {
	
	private String urlCodigoFonteBackend = "https://github.com/leandroneis/prova_softplan_back-end";
	private String urlCodigoFonteFrontend = "https://github.com/leandroneis/prova_softplan_front-end";

	private String urlDockerHubBackend = "https://hub.docker.com/repository/docker/lgn200/prova_softplan_leandro_neis_pessoa_api";
	private String urlDockerHubFrontend = "https://hub.docker.com/repository/docker/lgn200/prova_softplan_leandro_neis_pessoa_ui";

	@ApiOperation("Mostra o link do código fonte no repositório")
	@GetMapping("/source")
	public ResponseEntity<HashMap<String, String>> source() {
		HashMap<String, String> map = new HashMap<>();
		map.put("urlBackend",urlCodigoFonteBackend);
		map.put("urlFrontend",urlCodigoFonteFrontend);
		map.put("urlBackendDocker", urlDockerHubBackend);
		map.put("urlFrontendDocker", urlDockerHubFrontend);
		return ResponseEntity.ok(map);
	}
	
	

}
