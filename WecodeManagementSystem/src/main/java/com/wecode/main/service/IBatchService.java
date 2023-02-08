package com.wecode.main.service;

import java.util.List;

import com.wecode.main.domain.BatchModel;

public interface IBatchService {

	public BatchModel addBatch(BatchModel batchModel);

	public BatchModel getBatchById(Long id);

	public List<BatchModel> getAllBacth();

	public BatchModel updateBatchById(Long id, BatchModel batchModel);

	public BatchModel deleteBatchById(Long id);
}
