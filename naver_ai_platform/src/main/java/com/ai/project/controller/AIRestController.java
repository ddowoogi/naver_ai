package com.ai.project.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ai.project.model.ObjectVO;
import com.ai.project.model.PoseVO;
import com.ai.project.service.ObjectDetectionService;
import com.ai.project.service.PoseEstimationService;

@RestController
public class AIRestController {
	@Autowired
	PoseEstimationService poseService;
	
	@Autowired
	ObjectDetectionService objService;
	
	// 포즈 인식
	// 3. 파일 업로드하고 결과 받기
	@RequestMapping("/poseDetect")
	public ArrayList<PoseVO> poseDetect(@RequestParam("uploadFile") MultipartFile file) throws IOException {
		
		// 1. 파일 저장 경로 설정 : 실제 서비스 되는 위치 (프로젝트 외부에 저장)
		String uploadPath = "c:/upload/";
		// 마지막에 / 있어야 함
		
		// 2. 원본 파일 이름 알아오기
		String originalFileName = file.getOriginalFilename();
		String filePathName = uploadPath + originalFileName;
		
		// 3. 파일 생성
		File newFile = new File(filePathName);
		
		// 4. 서버로 전송
		file.transferTo(newFile);		
		
		ArrayList<PoseVO> poseList = poseService.poseEstimate(filePathName);		
			
		return poseList;
	}
	
	// 객체 탐지
	// 3. 파일 업로드하고 결과 받기
	@RequestMapping("/objectDetect")
	public ArrayList<ObjectVO> objectDetect(@RequestParam("uploadFile") MultipartFile file) throws IOException {
		
		// 1. 파일 저장 경로 설정 : 실제 서비스 되는 위치 (프로젝트 외부에 저장)
		String uploadPath = "c:/upload/";
		// 마지막에 / 있어야 함
		
		// 2. 원본 파일 이름 알아오기
		String originalFileName = file.getOriginalFilename();
		String filePathName = uploadPath + originalFileName;
		
		// 3. 파일 생성
		File newFile = new File(filePathName);
		
		// 4. 서버로 전송
		file.transferTo(newFile);		
		
		ArrayList<ObjectVO> objList = objService.objectDetect(filePathName);		
			
		return objList;
	}
}
