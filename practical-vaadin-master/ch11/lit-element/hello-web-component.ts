import { LitElement, html } from 'lit';
import { customElement } from 'lit/decorators.js';

@customElement('hello-web-component')
export class HelloWebComponent extends LitElement {
  render() {
    return html`
      <div>Hello, World!</div>
    `;
  }
}
