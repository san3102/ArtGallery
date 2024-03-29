package com.example.ArtGallery.user;


import com.example.ArtGallery.article.post.PostEntity;
import com.example.ArtGallery.article.post.PostService;
import com.example.ArtGallery.follow.FollowService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final PostService postService;
    private final FollowService followService;

    @GetMapping("/user/signup")
    public String signup(UserCreateForm userCreateForm) {
        return "signup_form";
    }

    @PostMapping("/user/signup")
    public String signup(@Valid UserCreateForm userCreateForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "signup_form";
        } else {
            userService.create(userCreateForm.getUsername(), userCreateForm.getNickname(), userCreateForm.getEmail(), userCreateForm.getPassword1());
        }
        return "redirect:/";
    }

    @GetMapping("/user/login")
    public String newLogin() {
        return "login_form";
    }

    @GetMapping("/user/detail_form/{loginUserNick}")
    public String userdetail(Model model, @PathVariable("loginUserNick") String loginUserNick, Authentication authentication, @RequestParam(name = "sortingOption", defaultValue = "1") int sortingOption) {

        String nicknameConfirm = null;
        String userEmail = null;
        if (authentication != null && authentication.isAuthenticated()) {
            // UserService에서 로그인 유저 닉네임 반환하는 메소드 호출
            nicknameConfirm = userService.getAuthNickname(userEmail, nicknameConfirm, authentication);
        }

        // 해당 유저정보 주인의 userEntity를 'user'로 템플릿에서 활용할 수 있게 반환
        UserEntity userEntity = this.userService.getUser(loginUserNick);
        model.addAttribute("user", userEntity);

        // loginUserNick: 게시물 주인
        // nicknameConfirm: 현재 로그인한 유저의 닉네임
        // 사용자가 선택한 정렬 기준을 서비스에 전달
        List<PostEntity> sortedPosts = postService.getSortedPosts_userdetail(sortingOption, loginUserNick);

        if (nicknameConfirm == null) {   // 비로그인 유저들을 위한 조건 추가

        } else {
            // 현재 로그인한 유저의 닉네임과 해당 프로필의 유저의 닉네임을 비교해서 isCurrentUser에 true, false를 반환

            model.addAttribute("isCurrentUser", nicknameConfirm.equals(loginUserNick));

            UserEntity loginUser = this.userService.getUser(nicknameConfirm);
            model.addAttribute("loginUser", loginUser);

            // 내가 해당 유저를 팔로잉중인지 확인하기 위한 true, false 반환
            boolean isFollowing = followService.isFollowing(loginUser, userEntity);
            model.addAttribute("isFollowing", isFollowing);

            // 해당 게시물에 좋아요, 저장하기를 누른 유저인지 아닌지 판별하여 post별로 Map에 저장
            Map<Integer, Boolean> isLikedMap = new HashMap<>();
            Map<Integer, Boolean> isSavedMap = new HashMap<>();
            Map<Integer, Boolean> isCurrentUserMap = new HashMap<>();
            if (!sortedPosts.isEmpty()) {
                for (PostEntity post : sortedPosts) {
                    boolean isLiked = postService.isLikedByCurrentUser(post.getId(), loginUser.getNickname());
                    boolean isSaved = userService.checkIfSavedByCurrentUser(loginUser.getNickname(), post.getId());
                    isLikedMap.put(post.getId(), isLiked);
                    isSavedMap.put(post.getId(), isSaved);

                    // 현재 로그인한 유저의 닉네임과 해당 프로필의 유저의 닉네임을 비교해서 isCurrentUser에 true, false를 반환
                    boolean isCurrentUser = nicknameConfirm.equals(post.getUserEntity().getNickname());
                    isCurrentUserMap.put(post.getId(), isCurrentUser);
                }
            }
            model.addAttribute("isCurrentUserPost", isCurrentUserMap);
            model.addAttribute("isLikedMap", isLikedMap);
            model.addAttribute("isSavedMap", isSavedMap);
        }

        // 뷰에 필요한 데이터 전달
//        model.addAttribute("postList", sortedPosts);
        model.addAttribute("sortingOption", sortingOption);


        int totalViews = 0;
        int totalLikes = 0;

        // list 수정중
        for (PostEntity post : sortedPosts) {
            totalViews += post.getPostView();
            totalLikes += post.getVoter().size();
        }

        model.addAttribute("postList", sortedPosts);
        model.addAttribute("postTotalView", totalViews);
        model.addAttribute("postTotalLikes", totalLikes);

        // 팔로워, 팔로잉 수 템플릿에서 사용할 수 있게 반환
        int followerCount = followService.getFollowerCount(userEntity.getId());
        int followingCount = followService.getFollowingCount(userEntity.getId());
        model.addAttribute("followerCount", followerCount);
        model.addAttribute("followingCount", followingCount);

        // 해당 유저가 저장한 게시물의 총 개수가 몇개인지 반환
        int totalCollectionCount = userService.getSavedPostCount(userEntity.getNickname());
        model.addAttribute("totalCollectionCount", totalCollectionCount);


        return "user_detail_form";
    }


    // user페이지 컬렉션 리스트 출력
    @GetMapping("/user/detail_form/{loginUserNick}/collection")
    public String userdetail_collection(Model model, @PathVariable("loginUserNick") String loginUserNick, Authentication authentication, @RequestParam(name = "sortingOption", defaultValue = "1") int sortingOption) {

        String nicknameConfirm = null;
        String userEmail = null;
        if (authentication != null && authentication.isAuthenticated()) {
            // UserService에서 로그인 유저 닉네임 반환하는 메소드 호출
            nicknameConfirm = userService.getAuthNickname(userEmail, nicknameConfirm, authentication);
        }

        // 해당 유저정보 주인의 userEntity를 'user'로 템플릿에서 활용할 수 있게 반환
        UserEntity userEntity = this.userService.getUser(loginUserNick);
        model.addAttribute("user", userEntity);

        // loginUserNick: 게시물 주인
        // nicknameConfirm: 현재 로그인한 유저의 닉네임
        // 사용자가 선택한 정렬 기준을 서비스에 전달
        List<PostEntity> sortedPosts = postService.getSortedPosts_userdetail(sortingOption, loginUserNick);
        List<Integer> collectionIds = userService.getUserCollections(loginUserNick);
        List<PostEntity> collectionList = postService.getPostsByCollectionIds(collectionIds);

        if (nicknameConfirm == null) {   // 비로그인 유저들을 위한 조건 추가

        } else {
            model.addAttribute("isCurrentUser", nicknameConfirm.equals(loginUserNick));

            UserEntity loginUser = this.userService.getUser(nicknameConfirm);
            model.addAttribute("loginUser", loginUser);

            // 내가 해당 유저를 팔로잉중인지 확인하기 위한 true, false 반환
            boolean isFollowing = followService.isFollowing(loginUser, userEntity);
            model.addAttribute("isFollowing", isFollowing);

            // 해당 게시물에 좋아요, 저장하기를 누른 유저인지 아닌지 판별하여 post별로 Map에 저장
            Map<Integer, Boolean> isLikedMap = new HashMap<>();
            Map<Integer, Boolean> isSavedMap = new HashMap<>();
            Map<Integer, Boolean> isCurrentUserMap = new HashMap<>();
            if (!sortedPosts.isEmpty()) {
                for (PostEntity post : collectionList) {
                    boolean isLiked = postService.isLikedByCurrentUser(post.getId(), loginUser.getNickname());
                    boolean isSaved = userService.checkIfSavedByCurrentUser(loginUser.getNickname(), post.getId());
                    isLikedMap.put(post.getId(), isLiked);
                    isSavedMap.put(post.getId(), isSaved);

                    // 현재 로그인한 유저의 닉네임과 해당 프로필의 유저의 닉네임을 비교해서 isCurrentUser에 true, false를 반환
                    boolean isCurrentUser = nicknameConfirm.equals(post.getUserEntity().getNickname());
                    isCurrentUserMap.put(post.getId(), isCurrentUser);
                }
            }
            model.addAttribute("isCurrentUserPost", isCurrentUserMap);
            model.addAttribute("isLikedMap", isLikedMap);
            model.addAttribute("isSavedMap", isSavedMap);
        }

        int totalViews = 0;
        int totalLikes = 0;

        // list 수정중
        for (PostEntity post : sortedPosts) {
            totalViews += post.getPostView();
            totalLikes += post.getVoter().size();
        }

        model.addAttribute("postList", collectionList);
        model.addAttribute("postTotalView", totalViews);
        model.addAttribute("postTotalLikes", totalLikes);

        // 팔로워, 팔로잉 수 템플릿에서 사용할 수 있게 반환
        int followerCount = followService.getFollowerCount(userEntity.getId());
        int followingCount = followService.getFollowingCount(userEntity.getId());
        model.addAttribute("followerCount", followerCount);
        model.addAttribute("followingCount", followingCount);

        // 해당 유저가 저장한 게시물의 총 개수가 몇개인지 반환
        int totalCollectionCount = userService.getSavedPostCount(userEntity.getNickname());
        model.addAttribute("totalCollectionCount", totalCollectionCount);


        return "user_detail_form";
    }

    @GetMapping("/")
    public String usernav(Model model, Authentication authentication, @RequestParam(name = "sortingOption", defaultValue = "1") int sortingOption) {

        // 인증된 사용자의 nickname 가져오기
        String nicknameConfirm = null;
        String userEmail = null;
        if (authentication != null && authentication.isAuthenticated()) {
            // UserService에서 로그인 유저 닉네임 반환하는 메소드 호출
            nicknameConfirm = userService.getAuthNickname(userEmail, nicknameConfirm, authentication);

            // 해당 nickname을 사용하여 유저 정보 가져오기
            UserEntity userEntity = userService.getUser(nicknameConfirm);
            model.addAttribute("userEntity", userEntity);

            List<PostEntity> postEntityList = this.postService.getList();
            model.addAttribute("postList", postEntityList);

            // 해당 게시물에 좋아요, 저장하기를 누른 유저인지 아닌지 판별하여 post별로 Map에 저장
            Map<Integer, Boolean> isLikedMap = new HashMap<>();
            Map<Integer, Boolean> isSavedMap = new HashMap<>();
            if (!postEntityList.isEmpty()) {
                for (PostEntity post : postEntityList) {
                    boolean isLiked = postService.isLikedByCurrentUser(post.getId(), userEntity.getNickname());
                    boolean isSaved = userService.checkIfSavedByCurrentUser(userEntity.getNickname(), post.getId());
                    isLikedMap.put(post.getId(), isLiked);
                    isSavedMap.put(post.getId(), isSaved);
                }
            }
            model.addAttribute("isLikedMap", isLikedMap);
            model.addAttribute("isSavedMap", isSavedMap);
        }

        // 사용자가 선택한 정렬 기준을 서비스에 전달
        List<PostEntity> sortedPosts = postService.getSortedPosts(sortingOption, nicknameConfirm);

        // 뷰에 필요한 데이터 전달
        model.addAttribute("postList", sortedPosts);
        model.addAttribute("sortingOption", sortingOption);

        return "index";     // 로그인한 상태일 때는 로그인한 유저의 데이터 객체가 인덱스로 넘어감
    }

    @GetMapping("/user/nickname_change_form")
    public String nickchange(UserNicknameModifyForm userNicknameModifyForm, Authentication authentication) {

        String nicknameConfirm = null;
        String userEmail = null;
        if (authentication != null && authentication.isAuthenticated()) {
            // UserService에서 로그인 유저 닉네임 반환하는 메소드 호출
            nicknameConfirm = userService.getAuthNickname(userEmail, nicknameConfirm, authentication);

        }

        // 해당 nickname을 사용하여 유저 정보 가져오기
        UserEntity userEntity = userService.getUser(nicknameConfirm);
        userNicknameModifyForm.setNickname(userEntity.getNickname());
        return "nick_change_form";
    }

    @PostMapping("/user/nickname_change_form")
    public String nickchangePost(@Valid UserNicknameModifyForm userNicknameModifyForm, Authentication authentication) {

        String nicknameConfirm = null;
        String userEmail = null;
        if (authentication != null && authentication.isAuthenticated()) {
            // UserService에서 로그인 유저 닉네임 반환하는 메소드 호출
            nicknameConfirm = userService.getAuthNickname(userEmail, nicknameConfirm, authentication);

        }
        UserEntity userEntity = userService.getUser(nicknameConfirm);
        userService.nickModify(userEntity, userNicknameModifyForm.getNickname());

        return "redirect:/";
    }

    // 저장하기 버튼 클릭시 컬렉션 추가
    @PostMapping("/collection/{nickname}/{postId}")
    public String addToCollection(@PathVariable String nickname, @PathVariable int postId) {
        userService.addToCollection(nickname, postId);
        return "redirect:/";
    }

    // 저장하기 취소시 컬렉션에서 제거
    @PostMapping("/removeCollection/{nickname}/{postId}")
    public String removeFromCollection(@PathVariable String nickname, @PathVariable int postId) {
        userService.removeFromCollection(nickname, postId);
        return "redirect:/"; // 즐겨찾기 제거 후 홈 페이지로 리다이렉트
    }
}
