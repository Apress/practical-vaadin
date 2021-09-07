class TimeButtonElement extends HTMLElement {

  constructor() {
    super();
    let button = document.createElement("button");
    button.textContent = this.getAttribute("text");
    button.classList.add("time-button");

    button.addEventListener("click", function () {
      let paragraph = document.createElement("p");
      paragraph.textContent = "The time is: " + Date();
      document.body.appendChild(paragraph);
    });

    this.appendChild(button);
  }
}

customElements.define("time-button", TimeButtonElement);
