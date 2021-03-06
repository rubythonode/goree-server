package com.goree.api.controller;

import com.goree.api.domain.Member;
import com.goree.api.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class MemberController {
    private static final String URL_PREFIX = "/member";
    public static final String FIND_MEMBER_BY_ID_URL = URL_PREFIX + "/id/{id}";
    public static final String DELETE_MEMBER_BY_ID_URL = URL_PREFIX + "/id/{id}";
    public static final String UPDATE_IMAGE_URL = URL_PREFIX + "/id/{memberId}/updateImage";
    public static final String REGISTER_MEMBER_URL = URL_PREFIX + "/join";
    public static final String FIND_MEMBER_ALL_URL = URL_PREFIX;

    @Autowired
    private MemberService memberService;

    /**
     *
     * @api {post} /member/join Register Member
     * @apiName Register Member
     * @apiGroup Member
     * @apiParam (Member) {json} User-info User info for to register
     * @apiParamExample {json} Request-Example:
     *   {
     *     "email": "arstarst@nate.com",
     *     "password": "qlalfqjsgh",
     *     "fullName": "Wonyoung Ju",
     *     "nickname": "nickname",
     *     "job": "programmer",
     *     "age": 22,
     *     "gender": "M",
     *     "phone": "010-1234-0173",
     *     "tags": [
     *       {
     *         "name": "memberTest"
     *       }
     *     ]
     *   }
     * @apiDescription 회원의 정보를 받아서 등록한다(회원가입)
     */
    @RequestMapping(value= REGISTER_MEMBER_URL, method=RequestMethod.POST)
    public Member registerMember(@RequestBody Member member) {
        return memberService.registerMember(member);
    }

    /**
     * @api {get} /member Find all of member
     * @apiName Find all of member
     * @apiGroup Member
     * @apiDescription 가입된 모든 멤버의 리스트를 가져온다.
     */
    @RequestMapping(value=FIND_MEMBER_ALL_URL, method=RequestMethod.GET)
    public List<Member> findMemberAll() {
        return memberService.findMemberAll();
    }

    /**
     * @api {post} /member/id/:id/updateImage Update profile image
     * @apiName Update profile image
     * @apiGroup Member
     * @apiParam {file} imageFile for member profile
     * @apiParam {number} member ID (sequence)
     * @apiDescription Member ID에 해당되는 회원의 이미지를 등록혹은 변경한다.
     */
    // TODO "등록 혹은 변경"인 경우 PUT 메서드가 더 적합함. 변경 필요.
    @RequestMapping(value= UPDATE_IMAGE_URL, method=RequestMethod.POST, consumes="multipart/form-data")
    public Member updateImage(@RequestPart MultipartFile file, @PathVariable long memberId) {
        return memberService.updateImage(memberId, file);
    }

    /**
     * @api {delete} /member/id/:id Delete Member By ID
     * @apiName Delete Member By ID
     * @apiGroup Member
     * @apiParam {number} userId    User ID (sequence)
     * @apiDescription 멤버의 id(시퀀스)를 받아서 해당 멤버를 삭제한다.
     */
    @RequestMapping(value= DELETE_MEMBER_BY_ID_URL, method=RequestMethod.DELETE)
    public void deleteMemberById(@PathVariable long id) {
        memberService.deleteMemberById(id);
    }

    /**
     * @api {get} /member/id/:id Get Member Info
     * @apiName Get Member Info
     * @apiGroup Member
     * @apiParam {number} User Id   User ID (sequence)
     * @apiDescription 해당 id(시퀀스)를 가진 회원의 정보를 가져온다.
     */
    @RequestMapping(value= FIND_MEMBER_BY_ID_URL, method=RequestMethod.GET)
    public Member findMemberById(@PathVariable long id) {
        return memberService.findMemberById(id);
    }


}
