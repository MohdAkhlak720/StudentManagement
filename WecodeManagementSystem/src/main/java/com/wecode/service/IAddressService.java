package com.wecode.service;

import java.util.List;

import com.wecode.domain.AddressModel;

public interface IAddressService {
	public AddressModel addAddress(AddressModel addressModel);

	public AddressModel getAddressById(Long id);

	public List<AddressModel> getAllAddress();

	public AddressModel updateAddressById(Long id, AddressModel addressModel);

	public AddressModel deleteAddressById(Long id);
}
