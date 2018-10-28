package edu.elfiady.ingé2.outils.launcher;

import java.io.IOException;
import java.net.URI;


import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.media.sse.SseFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.elfiady.ingé2.outils.resource.ReservationResource;




public class EmbeddedServer {

	
	private static final URI BASE_URI = URI.create("http://localhost:9996/");
	public static final String ROOT_PATH = "reservation";
	public static Logger LOGGER=LoggerFactory.getLogger(EmbeddedServer.class.getName());
	
	public static void main(String[] args) {
		try {
			LOGGER.info("Starting  server for Outils TP ingé2 ....");

			final ResourceConfig resourceConfig = new ResourceConfig(ReservationResource.class, SseFeature.class);

			final HttpServer server = GrizzlyHttpServerFactory.createHttpServer(BASE_URI, resourceConfig, false);
			Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {

				@Override
				public void run() {
					server.shutdownNow();
				}
			}));
			server.start();

			LOGGER.info("The server was successfully started .\n Try out "+BASE_URI+ROOT_PATH+"\nStop the server using CTRL+C");

			Thread.currentThread().join();
		} catch (final IOException  ex) {
			LOGGER.error("Exception during starting event server",ex);
		} catch (final InterruptedException e) {
			LOGGER.error("Exception during starting event server",e);
		}


	}

}
