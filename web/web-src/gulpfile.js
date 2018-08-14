'use strict';

var gulp = require('gulp');

gulp.paths = {
  src: 'src',
  dist: '../src/main/webapp',
  tmp: '.tmp',
  e2e: 'e2e'
};

require('require-dir')('./gulp');

gulp.task('build', ['clean'], function () {
    gulp.start('buildapp');
});
