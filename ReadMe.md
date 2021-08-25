#### 책을 기본적으로 읽으며 알고있던 지식이 아닌 책에서 몰랐던 지식을 정한다.
### 1. 스프링 MVC 와 Tymleaf p.96
-  ####RedirectAttributes
   -Controller 에서 redirect 사용시 RedirectAttributes 객체를 이용하여 기존 컨트롤러에서 수행하던 정보까지 같이 전달가능
   ```
   public String ex2(RedirectAttributes redirectAttributes){
        ...
        redirectAttributes.addFlashAttribute("result","success");
        redirectAttributes.addFlashAttribute("list",sampleDTOS);
        return "redirect:/sample/ex3";
    }
   ```
   