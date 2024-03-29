package com.ilson.api.no;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javassist.NotFoundException;

/**
 * @author Ilson Junior
 * @since 12/08/2019
 */

@Service
public class NoService {

	private final NoRepository noRepository;

	@Autowired
	public NoService(NoRepository noRepository) {
		this.noRepository = noRepository;
	}

	public Long save(NoEntity noEntity) {

		Boolean valid = noRepository.count() > 0 && noEntity.getParentId() == null && noRepository.findByParentIdIsNull() != null;
		Assert.isTrue(!valid, "Já existe uma raiz para está árvore!");
		
		Boolean valid1 = noRepository.count() == 0 && noEntity.getParentId() != null;
		Assert.isTrue(!valid1, "Favor Inserir uma raiz para arvore antes de adicionar nós!");
		noEntity = noRepository.save(noEntity);

		return noEntity.getId();
	}

	public NoEntity findTree() {
		return noRepository.findByParentIdIsNull();
	}

	public List<NoDTO> findByParentId(Long parentId) {
		return noRepository.findByParentId(parentId);
	}

	public void delete(Long id) throws NotFoundException {
		noRepository.findById(id).orElseThrow(() -> new NotFoundException(id + " não encontrado"));
		noRepository.deleteById(id);
	}
}
