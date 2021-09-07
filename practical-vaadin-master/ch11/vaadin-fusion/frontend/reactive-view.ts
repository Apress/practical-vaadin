import { LitElement, customElement, html, state } from 'lit-element';
import '@vaadin/vaadin-ordered-layout/vaadin-vertical-layout';
import '@vaadin/vaadin-text-field/vaadin-text-field';
import '@vaadin/vaadin-button/vaadin-button';
import '@vaadin/vaadin-notification/vaadin-notification';

@customElement('reactive-view')
export class ReactiveView extends LitElement {

  @state()
  private notificationOpen = false;

  @state()
  private name = '';

  render() {
    return html`
      <vaadin-vertical-layout theme="padding">
        <h1>Greeting</h1>
        <vaadin-text-field
          label="What's your name?"
          @value-changed='${(event:CustomEvent) => this.setName(event.detail.value)}'
        ></vaadin-text-field>
        <vaadin-button @click='${this.greet}'>Send</vaadin-button>
      </vaadin-vertical-layout>
      <vaadin-notification
        .opened="${this.notificationOpen}"
        .renderer=${this.greetingRenderer}
      ></vaadin-notification>
    `;
  }

  setName(newName: string) {
    this.name = newName;
    this.notificationOpen = false;
  }

  greet() {
    this.notificationOpen = true;
  }

  greetingRenderer = (root: HTMLElement) => {
    let message = 'Hello, ' + this.name;
    root.textContent = message;
  }
}
