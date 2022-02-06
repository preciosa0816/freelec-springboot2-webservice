package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.service.posts.PostsService;
import com.jojoldu.book.springboot.web.dto.PostsResponseDto;
import com.jojoldu.book.springboot.web.dto.PostsSaveRequestDto;
import com.jojoldu.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/test")
    public Long test(@RequestBody PostsSaveRequestDto requestDto) throws Exception{
        String[] test = requestDto.getTest().split("\n");

        int cnt = Integer.parseInt(test[0]);
        Integer[][] arr = new Integer[cnt][2];
        for(int i=0; i<cnt; i++) {
            String[] line = test[i+1].split(" ");
            arr[i][1] = Integer.parseInt(line[0]);
            arr[i][0] = Integer.parseInt(line[1]);
        }

        Arrays.sort(arr, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                if(o1[0].equals(o2[0])) {
                    return o1[1]-o2[1];
                }else {
                    return o1[0]-o2[0];
                }
            }
        });
        StringBuilder sb = new StringBuilder();

        for(Integer[] a : arr) {
            sb.append(a[1]+" "+a[0]).append("\n");
        }

        PostsSaveRequestDto result = PostsSaveRequestDto.builder().content(requestDto.getContent()).title(requestDto.getTitle()).test(sb.toString()).build();

        return postsService.save(result);
    }

    @PostMapping("/api/v1/posts")
    public Long Save(@RequestBody PostsSaveRequestDto requestDto) throws Exception{
        return postsService.save(requestDto);
    }

        @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById (@PathVariable Long id){
        return postsService.findById(id);
    }

}
