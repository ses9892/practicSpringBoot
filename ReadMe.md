#### 책을 기본적으로 읽으며 알고있던 지식이 아닌 책에서 몰랐던 지식을 정한다.
### 1. 스프링 MVC 와 Tymleaf (p.96)
-  #### RedirectAttributes
   -Controller 에서 redirect 사용시 RedirectAttributes 객체를 이용하여 기존 컨트롤러에서 수행하던 정보까지 같이 전달가능
   ```
   public String ex2(RedirectAttributes redirectAttributes){
        ...
        redirectAttributes.addFlashAttribute("result","success");
        redirectAttributes.addFlashAttribute("list",sampleDTOS);
        return "redirect:/sample/ex3";
    }
   ```
   <br>
- #### th:block (p.98)
   - 별도의 태그가 필요 없고 반드시 태그에
   ```th:text , th:value```등을 써야하는 제약이 없다.
     또한, 실제 화면에서 html 처리가 안되기때문에 루프등 로직처리용도로 많이 사용한다.<Br>
  ex)
  ``` 
     <ul>
        <th:block th:each="dto:${list}">
            <li th:text="${dto.sno %5==0}?${dto.sno}:${dto.first}"></li>
        </th:block>
     </ul>
     ```
- #### Link (p.102)
  ```
    <ul>
        <li th:each="dto:${list}">
            <a th:href="@{/sample/exView(sno=${dto.sno})}">[[${dto}]]</a>
        </li>
    </ul>
  
  (sno=${dto.sno}) ==> Query String 으로 바뀐다.
  ```
- #### number Formating
    - 숫자를 5자리 또는 다른 자리로 맞춰야하는경우 사용할 수 있다.
  ```        
  <li th:each="dto:${list}">
       [[${#numbers.formatInteger(dto.sno,5)}]]
  </li>ㅂ9ㅕ
  ```

- #### th:fragment
    - Layout을 나누고 각페이지에서 공통으로 사용되는 레이아웃을 파라미터로 넘길수 있다.
    
    #####[sideBar](https://github.com/ses9892/practicSpringBoot/blob/master/src/main/resources/templates/layout/basic.html)
    #####[exTemplate](https://github.com/ses9892/practicSpringBoot/blob/master/src/main/resources/templates/sample/exTemplate.html)
     
   
