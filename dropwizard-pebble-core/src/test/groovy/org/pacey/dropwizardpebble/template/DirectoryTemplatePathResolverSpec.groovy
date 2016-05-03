package org.pacey.dropwizardpebble.template

import org.pacey.dropwizardpebble.PebbleView
import spock.lang.Specification

class DirectoryTemplatePathResolverSpec extends Specification {

	def "should resolve template path to a directory"() {
		given:
		final PebbleView pebbleView = Mock(PebbleView.class)
		pebbleView.getTemplateName() >> "/views/homepage"

		when:
		final DirectoryTemplatePathResolver directoryTemplatePathResolver = new DirectoryTemplatePathResolver("/templates", ".peb");
		def templatePath = directoryTemplatePathResolver.resolve(pebbleView)

		then:
		templatePath == "/templates/views/homepage.peb"
	}

}
