window.ns = {
	init: function(element, view) {
		element.onclick = event =>
			view.$server.showClickNotification(event.clientX, event.clientY);
	},

	toggle: function(element) {
		jQuery(element).fadeToggle();
		return `Toggled at ${new Date().toLocaleString()}`;
	}
}
