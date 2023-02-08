package com.wecode.main.service;

import java.util.List;

import com.wecode.main.domain.FeeModel;
import com.wecode.main.enums.BatchEnum;

public interface IFeeService {
	public FeeModel createFee(FeeModel feeModel);

	public FeeModel getFeeById(Long id);

	public List<FeeModel> getAllFee();

	public FeeModel updateFeeById(Long id, FeeModel feeModel);

	public FeeModel removeFeeById(Long id);

	public List<FeeModel> getByBatchInfo(Long studentId, BatchEnum batch);

}
