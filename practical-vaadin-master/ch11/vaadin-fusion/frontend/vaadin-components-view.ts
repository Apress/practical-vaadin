import { LitElement, customElement, html } from 'lit-element';
import '@vaadin/vaadin-ordered-layout/vaadin-vertical-layout';
import '@vaadin/vaadin-ordered-layout/vaadin-horizontal-layout';
import '@vaadin/vaadin-combo-box/vaadin-combo-box';
import '@vaadin/vaadin-button/vaadin-button';
import '@vaadin/vaadin-text-field/vaadin-text-field';
import '@vaadin/vaadin-icons';

@customElement('vaadin-components-view')
export class VaadinComponentsView extends LitElement {
  render() {
    return html`
      <vaadin-vertical-layout theme="padding">
        <h1>Vaadin Components</h1>
        <vaadin-horizontal-layout>
          <vaadin-combo-box
            placeholder='Select a language...'
            items='[
              "Java", "TypeScript", "JavaScript"
            ]'
          ></vaadin-combo-box>
          <vaadin-button>
            <iron-icon icon="vaadin:check"></iron-icon>
            Select
          </vaadin-button>
        </vaadin-horizontal-layout>
      </vaadin-vertical-layout>
    `;
  }
}
