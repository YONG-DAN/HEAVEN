package org.kosta.heaven.model.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.heaven.model.vo.post.PagingBeanFive;
import org.kosta.heaven.model.vo.post.PhotoVO;
import org.kosta.heaven.model.vo.post.activity.ActivityVO;
import org.kosta.heaven.model.vo.post.join.JoinPostListVO;
import org.kosta.heaven.model.vo.post.join.JoinPostVO;
import org.kosta.heaven.model.vo.post.review.ReviewVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;
import org.springframework.web.multipart.MultipartFile;

@Repository
public class JoinDAOImpl implements JoinDAO {

	@Resource
	private SqlSessionTemplate template;

	// 신청하기
	@Override
	public void application(JoinPostVO joinPostVO) {
		template.insert("join.application", joinPostVO);
	}

	// 재능기부 목록
	@Override
	public JoinPostListVO readDonationList(int nowPage) {
		PagingBeanFive pbf = null;
		int totalDonationCount = template.selectOne("join.readDonationCount");
		if (nowPage == 0) {
			pbf = new PagingBeanFive(totalDonationCount);
		} else {
			pbf = new PagingBeanFive(totalDonationCount, nowPage);
		}
		List<JoinPostVO> donationList = template.selectList("join.readDonationList", pbf);
		JoinPostListVO donationListVO = new JoinPostListVO(donationList, pbf);

		return donationListVO;
	}

	// 재능기부 상세
	@Override
	public JoinPostVO readDonationDetail(int jpNo) {
		return template.selectOne("join.readDonationDetail", jpNo);
	}

	// 재능기부 참여하기
	@Override
	public void addUserActivity(ActivityVO activityVO) {
		template.insert("join.addUserActivity", activityVO);
	}

	// 참여한 재능기부에 모금 마일리지, 총 재능기부 참여자 수 수정
	@Override
	public void updateDonationMileageAndTotalEntry(ActivityVO activityVO) {
		template.update("join.updateDonationMileageAndTotalEntry", activityVO);

	}

	// 해당 재능기부에 대한 응원메시지 목록
	@Override
	public List<ActivityVO> readCheerUpMessageList(int jpNo) {
		return template.selectList("join.readCheerUpMessageList", jpNo);
	}

	// 해당 재능기부에 대한 후기 목록
	@Override
	public List<ReviewVO> readReviewList(int jpNo) {
		return template.selectList("join.readReviewList", jpNo);
	}

	// 성별이 남자인 참여자의 수
	@Override
	public int getDonationMaleEntry(int jpNo) {
		return template.selectOne("join.getDonationMaleEntry", jpNo);
	}
	
	

	// 성별이 남자인 참여자의 수
	@Override
	public int getDonationFemaleEntry(int jpNo) {
		return template.selectOne("join.getDonationFemaleEntry", jpNo);
	}
	
	// 로그인한 회원의 참여 여부
	@Override
	public ActivityVO findEntryByIdAndJpno(ActivityVO activityVO) {
		return template.selectOne("join.findEntryByIdAndJpno", activityVO);
	}

	@Override
	public String file_upload_save(MultipartFile uploadfile, ModelMap modelMap) {
		System.out.println("파일있음");
        OutputStream out = null;
        PrintWriter printWriter = null;
        String loadPath = null;
        try {
            // 파일명 얻기
            String fileName = uploadfile.getOriginalFilename();

            // 파일의 바이트 정보 얻기
            byte[] bytes = uploadfile.getBytes();
            // 파일의 저장 경로 얻기
            String uploadPath = "/java-kosta/was/spring-tomcat/webapps/heaven/resources/photo_upload/" + fileName;
            loadPath = "/heaven/resources/photo_upload/" + fileName;
            // 파일 객체 생성
            File file = new File(uploadPath);
            // 상위 폴더 존재 여부 확인
            if (!file.getParentFile().exists()) {
                // 상위 폴더가 존재 하지 않는 경우 상위 폴더 생성
                file.getParentFile().mkdirs();
            }           
            // 파일 아웃풋 스트림 생성
            out = new FileOutputStream(file);
            // 파일 아웃풋 스트림에 파일의 바이트 쓰기
            out.write(bytes);
            
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (printWriter != null) {
                    printWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return loadPath;
	}
	
	@Override
	public String photoUpload(HttpServletRequest request, PhotoVO vo) {
		System.out.println("단일");
	    String callback = vo.getCallback();
	    String callback_func = vo.getCallback_func();
	    String file_result = "";
	    try {
	        if(vo.getFiledata() != null && vo.getFiledata().getOriginalFilename() != null && !vo.getFiledata().getOriginalFilename().equals("")){
	            //파일이 존재하면
	            String original_name = vo.getFiledata().getOriginalFilename();
	            String ext = original_name.substring(original_name.lastIndexOf(".")+1);
	            System.out.println("1"+original_name+" / " + ext);
	            //파일 기본경로
	            String defaultPath = request.getSession().getServletContext().getRealPath("/");
	            System.out.println("2"+defaultPath);
	            //파일 기본경로 _ 상세경로
	            String path = defaultPath + "resources" + File.separator + "photo_upload" + File.separator;    
	            System.out.println("3"+defaultPath);
	            File file = new File(path);
	            System.out.println("path:"+path);
	            //디렉토리 존재하지 않을경우 디렉토리 생성
	            if(!file.exists()) {
	                file.mkdirs();
	            }
	            //서버에 업로드 할 파일명(한글문제로 인해 원본파일은 올리지 않는것이 좋음)
	            String realname = UUID.randomUUID().toString() + "." + ext;
	        ///////////////// 서버에 파일쓰기 /////////////////
	            vo.getFiledata().transferTo(new File(path+realname));
	            file_result += "&bNewLine=true&sFileName="+original_name+"&sFileURL=/resources/photo_upload/"+realname;
	        } else {
	            file_result += "&errstr=error";
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return "redirect:" + callback + "?callback_func="+callback_func+file_result;
		
	}
	
	@Override
	public void multiplePhotoUpload(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("멀티");
	    try {
	         //파일정보
	         String sFileInfo = "";
	         //파일명을 받는다 - 일반 원본파일명
	         String filename = request.getHeader("file-name");
	         //파일 확장자
	         String filename_ext = filename.substring(filename.lastIndexOf(".")+1);
	         //확장자를소문자로 변경
	         filename_ext = filename_ext.toLowerCase();
	         //파일 기본경로
	         String dftFilePath = request.getSession().getServletContext().getRealPath("/");
	         //파일 기본경로 _ 상세경로 - 시연경로
	         String filePath = dftFilePath + "resources" + File.separator + "photo_upload" + File.separator;
	         // 테스트 경로
	         //String filePath = "C:\\java-kosta\\framework\\workspace2\\gat\\src\\main\\webapp\\resources\\img" + File.separator;
	         File file = new File(filePath);
	         if(!file.exists()) {
	            file.mkdirs();
	         }
	         String realFileNm = "";
	         SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
	         String today= formatter.format(new java.util.Date());
	         realFileNm = today+UUID.randomUUID().toString() + filename.substring(filename.lastIndexOf("."));
	         String rlFileNm = filePath + realFileNm;
	         ///////////////// 서버에 파일쓰기 /////////////////
	         InputStream is = request.getInputStream();
	         OutputStream os=new FileOutputStream(rlFileNm);
	         int numRead;
	         byte b[] = new byte[Integer.parseInt(request.getHeader("file-size"))];
	         while((numRead = is.read(b,0,b.length)) != -1){
	            os.write(b,0,numRead);
	         }
	         if(is != null) {
	            is.close();
	         }
	         os.flush();
	         os.close();
	         ///////////////// 서버에 파일쓰기 /////////////////
	         // 정보 출력
	         sFileInfo += "&bNewLine=true";
	         // img 태그의 title 속성을 원본파일명으로 적용시켜주기 위함
	         sFileInfo += "&sFileName="+ filename;
	         //시연경로
	         sFileInfo += "&sFileURL="+"/heaven/resources/photo_upload/"+realFileNm;
	         //테스트파일경로
	         //sFileInfo += "&sFileURL="+"./resources/img/"+realFileNm;	         
	         PrintWriter print = response.getWriter();
	         print.print(sFileInfo);
	         print.flush();
	         print.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		
	}
	
	// 해당 재능기부 후기 작성
	@Override
	public void addReview(ReviewVO reviewVO) {
		template.insert("join.addReview", reviewVO);
	}


}
