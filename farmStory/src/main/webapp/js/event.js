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