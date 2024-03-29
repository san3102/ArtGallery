package com.example.ArtGallery.article.post;

import com.example.ArtGallery.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Collection;
import java.util.List;

public interface PostRepository extends JpaRepository<PostEntity, Integer>, JpaSpecificationExecutor<PostEntity>{
    List<PostEntity> findByUserEntity_Nickname(String nickname);

    // 최신순 정렬 DESC
    List<PostEntity> findAllByOrderByCreateDateDesc();
    List<PostEntity> findAllByUserEntity_NicknameOrderByCreateDateDesc(String nickname);

    // 인기(좋아요)순 정렬 DESC
    List<PostEntity> findAllByOrderByPostLikeDesc();
    List<PostEntity> findAllByUserEntity_NicknameOrderByPostLikeDesc(String nickname);

    // 팔로잉 (최신순)정렬 작업중
    List<PostEntity> findByUserEntity_NicknameInOrderByCreateDateDesc(List<String> nicknames);

    // 여러 개의 ID로 게시물을 조회하는 메소드 정의
    List<PostEntity> findByIdIn(List<Integer> ids);

    // 해당 해시태그들을 포함하는 게시물들을 조회하는 메서드
    List<PostEntity> findByHashtags_NameIn(List<String> hashtags);
}
