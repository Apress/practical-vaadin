import { LitElement, customElement, html } from 'lit-element';

@customElement('fusion-view')
export class FusionView extends LitElement {
  render() {
    return html`
      <div>Hello from Vaadin Fusion!</div>
    `;
  }
}
