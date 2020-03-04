package com.myproject.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.myproject.dto.DestinationDTO;
@Mapper
public interface DestinationMapper {

	public List<DestinationDTO> getDestination();
	public List<DestinationDTO> getDestinationByCountry(DestinationDTO request);
	public int insertDestination(DestinationDTO request);
	public int updateDestination(DestinationDTO request);
	public int deleteDestination(DestinationDTO request);

}
