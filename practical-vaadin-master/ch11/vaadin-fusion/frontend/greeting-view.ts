import { LitElement, customElement, html, query } from 'lit-element';
import '@vaadin/vaadin-ordered-layout/vaadin-vertical-layout';
import '@vaadin/vaadin-text-field/vaadin-text-field';
import '@vaadin/vaadin-button/vaadin-button';
import '@vaadin/vaadin-notification/vaadin-notification';

@customElement('greeting-view')
export class GreetingView extends LitElement {

  @query('#greeting-notification')
  private notification: any;

  private name: string = '';

  render() {
    return html`
      <vaadin-vertical-layout theme="padding">
        <h1>Greeting</h1>
        <vaadin-text-field
          id='name'
          label="What's your name?"
          @value-changed='${(event:any) => this.setName(event.detail.value)}'
        ></vaadin-text-field>
        <vaadin-button @click='${this.greet}'>Send</vaadin-button>
      </vaadin-vertical-layout>
      <vaadin-notification id='greeting-notification'>
      </vaadin-notification>
    `;
  }

  setName(newName: string) {
    this.name = newName;
    this.notification.close();
  }

  greet() {
    let message:string = 'Hello, ' + this.name;
    this.notification.renderer = (root:any) =>
        root.textContent = message;
    this.notification.open();
  }
}
