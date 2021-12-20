//Plugins a importar
var gulp = require('gulp'),
    sass = require('gulp-sass')(require('sass'));

function buildStyles() {
    return gulp.src('src/main/resources/static/scss/*.scss')
        .pipe(sass().on('error', sass.logError))
        .pipe(gulp.dest('src/main/resources/static/css/'))
}

exports.compila = buildStyles
