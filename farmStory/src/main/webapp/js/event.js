document.addEventListener("DOMContentLoaded", function () {
  const calendarDates = document.getElementById("calendarDates");
  const currentMonthElement = document.getElementById("month");
  const todayBtn = document.getElementById("btntoday");
  const prevBtn = document.getElementById("btnBack");
  const nextBtn = document.getElementById("btnNext");

  const today = new Date();
  let currentMonth = today.getMonth();
  let currentYear = today.getFullYear();

  const weekdays = ["Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"];
  
  //추가-------------------
  let selectedDate= null;	//선택된 날짜
  const eventTitleInput= document.getElementById("eventTitle");
  const saveEventButton= document.getElementById("saveEvent");
  const eventForm= document.getElementById("eventForm");
  
  //날짜 클릭 시 , 날짜 선택 및 폼 활성화
  calendarDates.addEventListener("click", function(e){
	if(e.target.classList.contains("date")){
		selectedDate= `${currentYear}-${currentMonth+1}-${e.target.textContent.padStart(2,'0')}`;
		alert(`선택된 날짜: ${selectedDate}`);
		
		//제목 입력 폼을 보이도록 설정
		eventForm.style.display= "block";
		eventTitleInput.disabled= false;
	}
  });
  
  //등록 버튼 클릭 시 이벤트 저장
  saveEventButton.addEventListener("click", function(){
	const title= eventTitleInput.value;
	if(!title || !selectedDate){
		alert("이벤트 제목과 날짜를 모두입력해주세요.");
		return;
	}
	//Ajax로 데이터 전송
	const formData= new FormData();
	formData.append("title", title);
	formData.append("regDate", selectedDate);
	
	fetch("/event.do",{
		method: "POST",
		body: formData,
	})
		.then((response)=> response.json())
		.then((data)=>{
			alert("이벤트가 등록되었습니다.");
			renderCalendar();	//달력 갱신
			eventTitleInput.value="";	//입력 필드 초기화
			eventTitleInput.disabled= true;	//다시 비활성화
			saveEventButton.disabled=true;	//등록 버튼 비활성화
			eventForm.style.display= "none";	//폼 숨기기
		})
		.catch((error)=>{
			console.error("Error:",error);
		});
  });

  //기존 달력 랜더링 함수
  function renderCalendar() {
    const firstDayOfMonth = new Date(currentYear, currentMonth, 1);
    const daysInMonth = new Date(currentYear, currentMonth + 1, 0).getDate();
    const startDayOfWeek = firstDayOfMonth.getDay();

    currentMonthElement.textContent = `${currentYear}년 ${currentMonth + 1}월`;
    calendarDates.innerHTML = "";

    // 요일 생성 (맨 위)
    weekdays.forEach((weekday) => {
      const dayElement = document.createElement("div");
      dayElement.classList.add("day");
      dayElement.textContent = weekday;
      calendarDates.appendChild(dayElement);
    });

    // 빈칸 채우기 (해당 월의 첫째 날이 시작되는 요일까지)
    for (let i = 0; i < startDayOfWeek; i++) {
      const emptyDate = document.createElement("div");
      emptyDate.classList.add("date", "empty");
      calendarDates.appendChild(emptyDate);
    }

    // 날짜 채우기
    for (let i = 1; i <= daysInMonth; i++) {
      const dateElement = document.createElement("div");
      dateElement.classList.add("date");
      dateElement.textContent = i;

      // 현재 날짜 강조
      if (
        currentYear === today.getFullYear() &&
        currentMonth === today.getMonth() &&
        i === today.getDate()
      ) {
        dateElement.classList.add("today");
      }

      calendarDates.appendChild(dateElement);
    }
  }

  renderCalendar();

  todayBtn.addEventListener("click", () => {
    currentYear = today.getFullYear(); 
    currentMonth = today.getMonth(); 
    renderCalendar(); 
  });
  

  prevBtn.addEventListener("click", () => {
    currentMonth--;
    if (currentMonth < 0) {
      currentMonth = 11;
      currentYear--;
    }
    renderCalendar();
  });

  nextBtn.addEventListener("click", () => {
    currentMonth++;
    if (currentMonth > 11) {
      currentMonth = 0;
      currentYear++;
    }
    renderCalendar();
  });
});