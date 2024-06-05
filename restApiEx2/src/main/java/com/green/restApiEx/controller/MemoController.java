package com.green.restApiEx.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.green.restApiEx.dto.MemoDto;
import com.green.restApiEx.entity.Memo;
import com.green.restApiEx.repository.MemoRepository;

@RestController
@RequestMapping("/memoapp")
public class MemoController {

	@Autowired
	private MemoRepository memoRepository;

	@RequestMapping("/main")
	public String root() {

		return "hello memo app";
	}

	// GET 메소드 (서버에 자료 요청할 때 - 어떤 자료인지 식별할 수 있는 파라미터가 있겠다.)
	// http://localhost:8092/memoapp/memo?mno=1
	@GetMapping("/memo")
	public Memo getMemo(@RequestParam("mno") Integer mno) {
		System.out.println("getMemo......... mno : " + mno);

		Optional<Memo> result = memoRepository.findById(mno); // 옵셔널로 한겹 싸서 result가 나옴
		Memo memo = result.get(); // 메모 객체를 얻어냄

		return memo; // 객체타입이니까 JSON형태로 데이터가 넘어간다.

	}

	// POST 메소드(서버에 자료 새로 등록할 때 - ajax로 json 데이터가 파라미터로 넘어온다. )
	// http://localhost:8092/memoapp/memo
	// {"title" : "test title..", "content" : "test content.....", "writer" : "hgd"}
	// -- json타입의 데이터

	@PostMapping("/memo")
	public Memo postMemo(@RequestBody MemoDto memoDto) { // json으로 넘어오는 거 아니면 그냥 커멘드 객체로 받을 수 있음
		System.out.println("postMemo......... memoDto : " + memoDto);

		Memo memo = new Memo();
		memo.setTitle(memoDto.getTitle());
		memo.setContent(memoDto.getContent());
		memo.setWriter(memoDto.getWriter());

		Memo result = memoRepository.save(memo);

		// return "postMemo......... memoDto : " + memoDto;
		// return memoDto; // 제이슨 타입으로 나온다.
		return result;
	}

	// PUT 메소드(서버에 자료 재 등록할 때/수정할 때)
	@PutMapping("/memo")
	public String putMemo(@RequestBody MemoDto memoDto) { //requestbody가 넘어온 json데이터를 memoDto형태로 바꿔줌
		System.out.println("putMemo......... memoDto : " + memoDto); // Memo memo로 받아도 된다..  MemoDto로 받아서 엔티티에 넣어주는 경우(지금 경우)도 있다..

		Memo memo = new Memo();
		memo.setMno(memoDto.getMno());
		memo.setTitle(memoDto.getTitle());
		memo.setContent(memoDto.getContent());
		memo.setWriter(memoDto.getWriter());

		Memo result = memoRepository.save(memo);

		// return "putMemo......... memoDto : " + memoDto;
		return result.toString(); // 문자열로 뿌려준다.
	}

	// DELETE 메소드(서버의 자료 삭제할 때 - 삭제할 자료를 식별할 수 있는 파라미터가 넘어온다.)
	// http://localhost:8092/memoapp/memo/1
	@DeleteMapping("/memo/{mno}") // 경로에 파라미터를 path 형태도 넣음 -> requestParam이 아닌 PATHvARIABLE 을 써주기
	public String deleteMemo(@PathVariable("mno") Integer mno) {
		System.out.println("deleteMemo......... mno : " + mno);

		memoRepository.deleteById(mno);

		return "deleteMemo......... mno : " + mno;

	}
}
