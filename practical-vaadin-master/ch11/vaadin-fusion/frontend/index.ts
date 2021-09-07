/******************************************************************************
 * NOTE:
 *     - You need to restart the dev-server after adding the new `index.ts` file.
 *       After that, all modifications to `index.ts` are recompiled automatically.
 *     - `index.js` is also supported if you don't want to use TypeScript.
 ******************************************************************************/


// import Vaadin client-router to handle client-side and server-side navigation
import {Router} from '@vaadin/router';

// import Flow module to enable navigation to Vaadin server-side views
import {Flow} from '@vaadin/flow-frontend/Flow';

import '@vaadin/vaadin-lumo-styles/all-imports';

import './fusion-view';
import './vaadin-components-view';
import './greeting-view';
import './reactive-view';

const {serverSideRoutes} = new Flow({
  imports: () => import('../target/frontend/generated-flow-imports')
});

const routes = [
  { path: 'fusion', component: 'fusion-view'},
  { path: 'vaadin-components', component: 'vaadin-components-view'},
  { path: 'greeting', component: 'greeting-view'},
  { path: 'reactive', component: 'reactive-view'},
  // for server-side, the next magic line sends all unmatched routes:
  ...serverSideRoutes // IMPORTANT: this must be the last entry in the array
];

// Vaadin router needs an outlet in the index.html page to display views
const router = new Router(document.querySelector('#outlet'));
router.setRoutes(routes);
