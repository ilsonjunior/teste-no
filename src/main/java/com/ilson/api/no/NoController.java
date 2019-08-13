package com.ilson.api.no;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ilson Junior
 * @since 12/08/2019
 */

@RestController
@RequestMapping(value="/no")
public class NoController {

	@Autowired
	private NoService noService;

	@PostMapping("/save")
    public ResponseEntity<Long> save(@RequestBody NoEntity noEntity) {
		return ResponseEntity.ok().body(noService.save(noEntity));

    }

	@PutMapping("/update")
    public ResponseEntity<Long> update(@RequestBody NoEntity noEntity) {
        return ResponseEntity.ok().body(noService.save(noEntity));
    }

	@GetMapping("/findTree")
    public ResponseEntity<NoEntity> findByParentId() {
        return ResponseEntity.ok().body(noService.findTree());
    }

	@GetMapping("/findByParentId/{parentId}")
    public ResponseEntity<List<NoDTO>> findByParentId(@PathVariable("parentId") Long parentId) {
        return ResponseEntity.ok().body(noService.findByParentId(parentId));
    }
	
	@DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
		noService.delete(id);
        return ResponseEntity.ok("Deleted");
    }

}