package com.goree.api.service;


import com.goree.api.domain.MeetingNoteComment;
import com.goree.api.mapper.MeetingNoteCommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MeetingNoteCommentService {
    @Autowired
    private MeetingNoteCommentMapper meetingNoteCommentMapper;


    public MeetingNoteComment writeMeetingNoteComment(MeetingNoteComment meetingNoteComment) {
        meetingNoteCommentMapper.insertMeetingNoteComment(meetingNoteComment);
        return findMeetingNoteCommentLastOneByMeetingNoteId(meetingNoteComment.getMeetingNote().getId());
    }

    public MeetingNoteComment findMeetingNoteCommentLastOneByMeetingNoteId(long meetingNoteId) {
        return meetingNoteCommentMapper.selectMeetingNoteCommentLastOneByMeetingNoteId(meetingNoteId);
    }
}
