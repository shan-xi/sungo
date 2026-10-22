# SUN GO INDUSTRY — Official Website

A clean full-stack rebuild of the SUN GO company website based on the uploaded HTTrack archive. The project uses React + TypeScript, Spring Boot, PostgreSQL, Docker Compose, and Nginx. Only a curated selection of the original images is included; the old audio/video files and duplicated crawl output are intentionally excluded.

## Features

- Responsive bilingual-ready corporate landing page (current content is Traditional Chinese with English company branding)
- Product introduction catalogue with dedicated `/products/:id` detail pages (legacy `/products#product-ID` links are redirected to details)
- Home-page image carousel, patent-products section, and company activity gallery
- Separate `/services`, `/patents`, and `/activities` pages, preserving the original site topics while giving product introduction and manufacturing services different roles
- Original SUN GO logo displayed in the public header and admin sign-in
- News/updates list
- Company capabilities, contact information, and inquiry form
- Admin sign-in with JWT authentication
- Admin management for products and news (create, edit, publish/unpublish, delete)
- Admin inbox for customer inquiries
- Site settings editing for phone, fax, email, address, and company introduction
- Image upload to persistent Docker volume
- PostgreSQL persistence, container health checks, Nginx reverse proxy

## Start with Docker

Requirements: Docker Desktop / Docker Engine with Compose.

1. Copy `.env.example` to `.env`.
2. Change `JWT_SECRET` to a long random secret and set a strong `ADMIN_PASSWORD`.
3. Run:

   ```bash
   docker compose up --build -d
   ```

4. Open `http://localhost` for the public site and `http://localhost/admin/login` for the admin panel.
5. Default admin username is `admin`; password comes from `ADMIN_PASSWORD` in `.env` (the example value is for local development only—change it before use).

The first startup seeds a small starter catalogue and company settings. The admin user is created from environment variables if it does not already exist.

## Local development

### Backend

- Java 21 and Maven 3.9+
- PostgreSQL 16
- Set `DATABASE_URL`, `DATABASE_USERNAME`, `DATABASE_PASSWORD`, `JWT_SECRET`, `ADMIN_USERNAME`, `ADMIN_PASSWORD`, and `UPLOAD_DIR`.
- From `backend/`: `mvn spring-boot:run`

### Frontend

- Node.js 22+
- From `frontend/`: `npm install && npm run dev`
- Vite proxies `/api` to `http://localhost:8080` in development.

## API overview

- `POST /api/auth/login`
- `GET /api/public/products`, `GET /api/public/news`, `GET /api/public/settings`
- `POST /api/public/inquiries`
- Admin: `/api/admin/products`, `/api/admin/news`, `/api/admin/inquiries`, `/api/admin/settings`, `/api/admin/uploads`

## Production checklist

- Set a unique long `JWT_SECRET`, strong admin password, and database password.
- Put HTTPS/TLS in front of Nginx (for example, via a load balancer or Certbot-managed host Nginx).
- Configure backups for PostgreSQL and the `uploads` Docker volume.
- Review legal/privacy text and company details before going live.
- Replace the starter product names/descriptions with verified catalog data. Some image-to-product mappings are provisional because the legacy filenames are not descriptive.
- Configure mail delivery if inquiry notifications should be emailed; this starter stores inquiries in the admin inbox and does not send email automatically.

## Asset strategy

Only 20 selected assets from the original archive are included in `frontend/public/assets`. The complete HTTrack backup should be kept separately as a read-only reference. Old `.wma`, `.wmv`, duplicate language assets, counters, legacy scripts, and crawled HTML pages are not copied into this project.
