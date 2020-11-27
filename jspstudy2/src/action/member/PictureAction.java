package action.member;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import action.Action;
import action.ActionForward;
/*
1. 이미지 파일 업로드. request 객체 사용불가
	이미지파일 업로드 위치

*/
public class PictureAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String path=request.getServletContext().getRealPath("")+"model2/member/picture/";
		String fname=null;
		File f=new File(path);
		if(!f.exists()){
			f.mkdirs();
		}
		//업로드 실행
		MultipartRequest multi=new MultipartRequest(request, path, 10*1024*1024,"UTF-8");
		//fname:<input type="file" name="picture">선택한 파일의 이름
//				업로드된 파일의 이름
		fname=multi.getFilesystemName("picture");
		//new File(path+fname):업로드된 파일의 절대 경로.
		//bi: 이미지 파일을 읽어서 메모리에 저장
		BufferedImage bi=ImageIO.read(new File(path+fname));
		int width=bi.getWidth()/3; //원본이미지 가로크기의 3분의1
		int height=bi.getHeight()/3; //원본이미지 세로크기의 3분의 1
		//섬네일이미지를 그리기 위한 도화지
		BufferedImage thumb=new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		//g: 그리기 도구
		Graphics2D g=thumb.createGraphics();
		g.drawImage(bi, 0, 0, width, height,null);
		f=new File(path + "sm_"+fname);
		ImageIO.write(thumb, "jpg", f);
		request.setAttribute("fname", fname);
		return new ActionForward();
	}
}
