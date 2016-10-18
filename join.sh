./ffmpeg -i 570-0.mp4 -c copy -bsf:v h264_mp4toannexb -f mpegts 570-0.ts
sleep 1
./ffmpeg -i 570-1.mp4 -c copy -bsf:v h264_mp4toannexb -f mpegts 570-1.ts
sleep 1
./ffmpeg -i 570-2.mp4 -c copy -bsf:v h264_mp4toannexb -f mpegts 570-2.ts
sleep 1
./ffmpeg -i 570-3.mp4 -c copy -bsf:v h264_mp4toannexb -f mpegts 570-3.ts
sleep 1
./ffmpeg -i 'concat:570-0.ts|570-1.ts|570-2.ts|570-3.ts' -c copy -bsf:a aac_adtstoasc 570.mp4
sleep 1
rm -rf 570-0.ts 570-1.ts 570-2.ts 570-3.ts
./ffmpeg -i 569-0.mp4 -c copy -bsf:v h264_mp4toannexb -f mpegts 569-0.ts
sleep 1
./ffmpeg -i 569-1.mp4 -c copy -bsf:v h264_mp4toannexb -f mpegts 569-1.ts
sleep 1
./ffmpeg -i 569-2.mp4 -c copy -bsf:v h264_mp4toannexb -f mpegts 569-2.ts
sleep 1
./ffmpeg -i 569-3.mp4 -c copy -bsf:v h264_mp4toannexb -f mpegts 569-3.ts
sleep 1
./ffmpeg -i 'concat:569-0.ts|569-1.ts|569-2.ts|569-3.ts' -c copy -bsf:a aac_adtstoasc 569.mp4
sleep 1
rm -rf 569-0.ts 569-1.ts 569-2.ts 569-3.ts
./ffmpeg -i 555-0.mp4 -c copy -bsf:v h264_mp4toannexb -f mpegts 555-0.ts
sleep 1
./ffmpeg -i 555-1.mp4 -c copy -bsf:v h264_mp4toannexb -f mpegts 555-1.ts
sleep 1
./ffmpeg -i 555-2.mp4 -c copy -bsf:v h264_mp4toannexb -f mpegts 555-2.ts
sleep 1
./ffmpeg -i 555-3.mp4 -c copy -bsf:v h264_mp4toannexb -f mpegts 555-3.ts
sleep 1
./ffmpeg -i 'concat:555-0.ts|555-1.ts|555-2.ts|555-3.ts' -c copy -bsf:a aac_adtstoasc 555.mp4
sleep 1
rm -rf 555-0.ts 555-1.ts 555-2.ts 555-3.ts
./ffmpeg -i 434-436-0.mp4 -c copy -bsf:v h264_mp4toannexb -f mpegts 434-436-0.ts
sleep 1
./ffmpeg -i 434-436-1.mp4 -c copy -bsf:v h264_mp4toannexb -f mpegts 434-436-1.ts
sleep 1
./ffmpeg -i 434-436-2.mp4 -c copy -bsf:v h264_mp4toannexb -f mpegts 434-436-2.ts
sleep 1
./ffmpeg -i 434-436-3.mp4 -c copy -bsf:v h264_mp4toannexb -f mpegts 434-436-3.ts
sleep 1
./ffmpeg -i 434-436-4.mp4 -c copy -bsf:v h264_mp4toannexb -f mpegts 434-436-4.ts
sleep 1
./ffmpeg -i 434-436-5.mp4 -c copy -bsf:v h264_mp4toannexb -f mpegts 434-436-5.ts
sleep 1
./ffmpeg -i 434-436-6.mp4 -c copy -bsf:v h264_mp4toannexb -f mpegts 434-436-6.ts
sleep 1
./ffmpeg -i 434-436-7.mp4 -c copy -bsf:v h264_mp4toannexb -f mpegts 434-436-7.ts
sleep 1
./ffmpeg -i 434-436-8.mp4 -c copy -bsf:v h264_mp4toannexb -f mpegts 434-436-8.ts
sleep 1
./ffmpeg -i 'concat:434-436-0.ts|434-436-1.ts|434-436-2.ts|434-436-3.ts|434-436-4.ts|434-436-5.ts|434-436-6.ts|434-436-7.ts|434-436-8.ts' -c copy -bsf:a aac_adtstoasc 434-436.mp4
sleep 1
rm -rf 434-436-0.ts 434-436-1.ts 434-436-2.ts 434-436-3.ts 434-436-4.ts 434-436-5.ts 434-436-6.ts 434-436-7.ts 434-436-8.ts
./ffmpeg -i 566-0.mp4 -c copy -bsf:v h264_mp4toannexb -f mpegts 566-0.ts
sleep 1
./ffmpeg -i 566-1.mp4 -c copy -bsf:v h264_mp4toannexb -f mpegts 566-1.ts
sleep 1
./ffmpeg -i 566-2.mp4 -c copy -bsf:v h264_mp4toannexb -f mpegts 566-2.ts
sleep 1
./ffmpeg -i 566-3.mp4 -c copy -bsf:v h264_mp4toannexb -f mpegts 566-3.ts
sleep 1
./ffmpeg -i 'concat:566-0.ts|566-1.ts|566-2.ts|566-3.ts' -c copy -bsf:a aac_adtstoasc 566.mp4
sleep 1
rm -rf 566-0.ts 566-1.ts 566-2.ts 566-3.ts
